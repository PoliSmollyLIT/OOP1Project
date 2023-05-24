package bg.tu_varna.sit.libraryProject.books;

public enum Raiting {
        ONE_STAR("🌕"),
        STAR_AND_A_HALF("🌕🌗"), //\uD83C\uDF15\uD83C\uDF17
        TWO_STARS("🌕🌕"),
        TWO_STARS_AND_A_HALF("🌕🌕🌗"),
        THREE_STARS("🌕🌕🌕"),
        THREE_STARS_AND_A_HALF("🌕🌕🌕🌗"),
        FOUR_STARS("🌕🌕🌕🌕"),
        FOUR_STARS_AND_A_HALF("🌕🌕🌕🌕🌗"),
        FIVE_STARS("🌕🌕🌕🌕🌕");

        private String output;

        private Raiting(String output){
                this.output = output;
        }

        public String getRaiting(){
                return this.output;
        }
}