package bg.tu_varna.sit.libraryProject.books;


public enum Raiting {
        ONE_STAR("1/5"),
        STAR_AND_A_HALF("1,5/5"), //\uD83C\uDF15\uD83C\uDF17
        TWO_STARS("2/5"),
        TWO_STARS_AND_A_HALF("2,5/5"),
        THREE_STARS("3/5"),
        THREE_STARS_AND_A_HALF("3,5/5"),
        FOUR_STARS("4/5"),
        FOUR_STARS_AND_A_HALF("4,5/5"),
        FIVE_STARS("5/5 ;-)");

        private String output;

        private Raiting(String output){
                this.output = output;
        }

        public String getRaiting(){
                return this.output;
        }
}