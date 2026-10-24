package Scales;

public class Scale {
    static String[] notes = {"C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};
    int[] intervals;
    int root;
    public Scale(int[] intervals, int root) {
        this.intervals = intervals;
        this.root = root;
    }
    public static Scale createScaleByTemplate(Template t, int root) {
        return new Scale(t.intervals, root);
    }

    public String toString() {
        String result = "";
        result += notes[root];
        int curIndex = root;
        for (int i = 0; i < intervals.length; i++) {
            curIndex += intervals[i];
            curIndex = curIndex % notes.length;
            result += " " + notes[curIndex];
        }
        return result;
    }

    public int getSize() {
        return intervals.length + 1; // 7 intervals is 8 note scale
    }

    static class Template {
        int[] intervals;

        public Template(int[] intervals) {
            //possible to add restrictions such as no repeated notes
            //(nonzero intervals)
            this.intervals = intervals;
        }
    }

}
