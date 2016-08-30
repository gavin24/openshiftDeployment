package za.cput.gavin.zoo.Domain;

import java.sql.Time;
import java.util.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class Show {
    private String name;
    private Date showDay;
    private Time showTime;

    public Show(Builder builder) {
        name=builder.name;
        showDay=builder.showDay;
        showTime=builder.showTime;
    }



    public String getname() {
        return name;
    }

    public Date getDay() {
        return showDay;
    }

    public Time getTime() {
        return showTime;
    }

    public static class Builder{
        private String name;
        private Date showDay;
        private Time showTime;

        public Builder (String name){
            this.name=name;

        }

        public Builder day(Date value){
            this.showDay=value;
            return this;
        }

        public Builder time(Time value){
            this.showTime=value;
            return this;
        }

        public Builder copy(Show value){
            this.name=value.name;
            this.showDay=value.showDay;
            this.showTime=value.showTime;
            return this;
        }

        public Show build(){
            return new Show(this);
        }
    }
}
