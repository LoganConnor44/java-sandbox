package loganconnor44.katas;

public class ReverseStringUsingRecursion {
    public char[] reverse(char[] word) {
        if (word.length != 0) {
            int redTeam = 0;
            int blueTeam = word.length - 1;

            while (redTeam < blueTeam) {
                this.rev(word, redTeam, blueTeam);
                redTeam++;
                blueTeam--;
            }
        }

        return word;
    }

    private void rev(char[] word, int red, int blue) {
        if (red >= blue) {
            return;
        }
        char temp = word[red];
        word[red] = word[blue];
        word[blue] = temp;
    }
}
