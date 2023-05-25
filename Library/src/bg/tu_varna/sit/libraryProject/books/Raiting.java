package bg.tu_varna.sit.libraryProject.books;

import java.nio.charset.StandardCharsets;

public enum Raiting {
        ONE_STAR(new String("🌕".getBytes(), StandardCharsets.UTF_8)),
        STAR_AND_A_HALF(new String("🌕🌗".getBytes(), StandardCharsets.UTF_8)), //\uD83C\uDF15\uD83C\uDF17
        TWO_STARS(new String("🌕🌕".getBytes(), StandardCharsets.UTF_8)),
        TWO_STARS_AND_A_HALF(new String("🌕🌕🌗".getBytes(), StandardCharsets.UTF_8)),
        THREE_STARS(new String("🌕🌕🌕".getBytes(), StandardCharsets.UTF_8)),
        THREE_STARS_AND_A_HALF(new String("🌕🌕🌕🌗".getBytes(), StandardCharsets.UTF_8)),
        FOUR_STARS(new String("🌕🌕🌕🌕".getBytes(), StandardCharsets.UTF_8)),
        FOUR_STARS_AND_A_HALF(new String("🌕🌕🌕🌕🌗".getBytes(), StandardCharsets.UTF_8)),
        FIVE_STARS(new String("🌕🌕🌕🌕🌕".getBytes(), StandardCharsets.UTF_8));

        private String output;

        private Raiting(String output){
                this.output = output;
        }

        public String getRaiting(){
                return this.output;
        }
}