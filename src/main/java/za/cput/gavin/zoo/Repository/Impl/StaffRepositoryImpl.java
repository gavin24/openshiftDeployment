package com.ackerman.j.gavin.zootrack.Repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ackerman.j.gavin.zootrack.Config.DbConstants.DbConstants;
import com.ackerman.j.gavin.zootrack.Config.Util.AppUtil;
import com.ackerman.j.gavin.zootrack.Domain.Employee;
import com.ackerman.j.gavin.zootrack.Domain.Staff;
import com.ackerman.j.gavin.zootrack.Repository.FoodRepository;
import com.ackerman.j.gavin.zootrack.Repository.StaffRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-04-23.
 */
public class StaffRepositoryImpl extends SQLiteOpenHelper implements StaffRepository {
    public static final String TABLE_NAME = "staff";
    private SQLiteDatabase db;



    public static final String COLUMN_ID = "id";
    public static final String COLUMN_WORKDAY = "workDay";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SURNAME + " TEXT UNIQUE NOT NULL , "
            + COLUMN_AGE + " INTEGER  NOT NULL, "
            + COLUMN_COUNTRY + " TEXT  NOT NULL , "
            + COLUMN_PASSWORD + " TEXT UNIQUE  NOT NULL, "
            + COLUMN_EMAIL + " TEXT UNIQUE  NOT NULL , "
            + COLUMN_NAME + " TEXT NOT NULL ,"
            + COLUMN_WORKDAY + " DATE NOT NULL ); ";



    public StaffRepositoryImpl(Context context) {
        super(context, DbConstants.DATABASE_NAME, null, DbConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Staff findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_SURNAME,
                        COLUMN_AGE,
                        COLUMN_COUNTRY,
                        COLUMN_PASSWORD,
                        COLUMN_EMAIL,
                        COLUMN_NAME,
                        COLUMN_WORKDAY},

                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            Employee employee = new Employee.Builder()
                    //.id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                    .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                    .Country(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY)))
                    .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                    .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))

                    .build();

            List<Employee> employeeList = new ArrayList<Employee>();
            employeeList.add(employee);

            final Staff staff = new Staff.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .Day(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_WORKDAY))))
                    .employee(employeeList)
                    .build();
            return staff;
        } else {
            return null;
        }
    }



    @Override
    public Staff save(Staff entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_WORKDAY, entity.getDay().toString());
        values.put(COLUMN_SURNAME, entity.getsEmployees().get(0).getsurname());
        values.put(COLUMN_AGE, entity.getsEmployees().get(0).getAge());
        values.put(COLUMN_COUNTRY, entity.getsEmployees().get(0).getCountry());
        values.put(COLUMN_PASSWORD, entity.getsEmployees().get(0).getPassword());
        values.put(COLUMN_EMAIL, entity.getsEmployees().get(0).getEmail());
        values.put(COLUMN_NAME, entity.getsEmployees().get(0).getName());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Staff insertedEntity = new Staff.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Staff update(Staff entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_WORKDAY, entity.getDay().toString());
        values.put(COLUMN_SURNAME, entity.getsEmployees().get(0).getsurname());
        values.put(COLUMN_AGE, entity.getsEmployees().get(0).getAge());
        values.put(COLUMN_COUNTRY, entity.getsEmployees().get(0).getCountry());
        values.put(COLUMN_PASSWORD, entity.getsEmployees().get(0).getPassword());
        values.put(COLUMN_EMAIL, entity.getsEmployees().get(0).getEmail());
        values.put(COLUMN_NAME, entity.getsEmployees().get(0).getName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Staff delete(Staff entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Staff> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Staff> staff = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                Employee employee = new Employee.Builder()
                        //.id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .age(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)))
                        .Country(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY)))
                        .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                        .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))

                        .build();

                List<Employee> employeeList = new ArrayList<Employee>();
                employeeList.add(employee);

                final Staff election = new Staff.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .Day(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_WORKDAY))))
                        .employee(employeeList)
                        .build();
                staff.add(election);
            } while (cursor.moveToNext());
        }
        return staff;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
