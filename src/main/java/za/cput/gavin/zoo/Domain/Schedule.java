package za.cput.gavin.zoo.Domain;

import java.sql.Date;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class Schedule {
    private List<Show> show;
    private String type;
    private String duration;
    private String coach;


    public Schedule(Builder builder) {
        type=builder.type;
        duration=builder.duration;
        coach=builder.coach;
        show=builder.show;
    }

    public String getType() {
        return type;
    }

    public String getDuration() {
        return duration;
    }

    public List<Show> getshows() {
        return show;
    }
    public String getCoach() {
        return coach;
    }



    public static class Builder{
        private String type;
        private String duration;
        private String coach;
        List<Show> show;

        public Builder(String type) {
            this.type = type;
        }

        public Builder duration(String value){
            this.duration=value;
            return this;
        }



        public Builder coach(String value){
            this.coach=value;
            return this;
        }
        public Builder show(List<Show> show) {
            this.show = show;
            return this;
        }
     /*   public Builder show(Show value){
            this.show=value;
            return this;
        }*/
        public Builder copy(Schedule value){
            this.type=value.type;
            this.duration=value.duration;

            this.coach=value.coach;

            this.show=value.show;
            return this;
        }

        public Schedule build(){
            return new Schedule(this);
        }
    }
}
