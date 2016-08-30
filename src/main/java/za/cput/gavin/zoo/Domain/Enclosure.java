package za.cput.gavin.zoo.Domain;

import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class Enclosure {
    private Show show;
    private String type;
    private String name;
    private String coach;

    public Enclosure(Builder builder) {
        type=builder.type;
        name=builder.name;
        coach=builder.coach;
        coach=builder.coach;
        show=builder.show;
    }
    public Show getshows() {
        return show;
    }
    public String getType() {
        return type;
    }

    public String getname() {
        return name;
    }


    public String getCoach() {
        return coach;
    }



    public static class Builder{
        private String type;
        private String name;

        private String coach;

        private Show show;

        public Builder(String type) {
            this.type = type;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }



        public Builder coach(String value){
            this.coach=value;
            return this;
        }

        public Builder show(Show value){
            this.show=value;
            return this;
        }
        public Builder copy(Enclosure value){
            this.type=value.type;
            this.name=value.name;

            this.coach=value.coach;

            this.show=value.show;
            return this;
        }

        public Enclosure build(){
            return new Enclosure(this);
        }
    }
}
