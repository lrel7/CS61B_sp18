public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int off = Math.abs(x - y);
        return off == 1;
    }

}
