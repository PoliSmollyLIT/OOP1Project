package bg.tu_varna.sit.libraryProject.books;

public enum Raiting {
        ONE_STAR("\uD83C\uDF15"),
        STAR_AND_A_HALF("\uD83C\uDF15\uD83C\uDF17"),
        TWO_STARS("\uD83C\uDF15\uD83C\uDF15"),
        TWO_STARS_AND_A_HALF("\uD83C\uDF15\uD83C\uDF15\uD83C\uDF17"),
        THREE_STARS("\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15"),
        THREE_STARS_AND_A_HALF("\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15\uD83C\uDF17"),
        FOUR_STARS("\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15"),
        FOUR_STARS_AND_A_HALF("\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15\uD83C\uDF17"),
        FIVE_STARS("\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15\uD83C\uDF15");

        private String output;

        private Raiting(String output){
                this.output = output;
        }

        public String getRaiting(){
                return this.output;
        }
}