package za.cput.gavin.zoo.Factories.Impl;

import za.cput.gavin.zoo.Domain.Enclosure;
import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Factories.EnclosureFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class EnclosureFactoryImpl implements EnclosureFactory{
    private static EnclosureFactoryImpl factory = null;

    private EnclosureFactoryImpl(){

    }

    public static EnclosureFactoryImpl getInstance(){
        if (factory == null)
            factory = new EnclosureFactoryImpl();

        return factory;
    }
    public Enclosure createEnclosure(String type,String name, String coach, Show show)
    {
        Enclosure staff = new Enclosure.Builder(type).name(name).coach(coach).show(show)
                .build();

        return staff;
    }
}
