class Solution {
    public int calPoints(String[] operations) {
     Stack<Integer> scoreStack = new Stack<>();

        for (String op : operations) {
            switch (op) {
                case "+":
                    // Record a new score that is the sum of the last two scores
                    int top = scoreStack.pop();
                    int newScore = top + scoreStack.peek();
                    scoreStack.push(top);      // Put the first one back
                    scoreStack.push(newScore); // Push the new sum
                    break;

                case "D":
                    // Record a new score that is double the last score
                    scoreStack.push(2 * scoreStack.peek());
                    break;

                case "C":
                    // Invalidate the last score, removing it from the record
                    scoreStack.pop();
                    break;

                default:
                    // It's an integer, change it from String to int and push it
                    scoreStack.push(Integer.parseInt(op));
                    break;
            }
        }

        // Calculate the grand total of all scores left in the stack
        int totalScore = 0;
        for (int score : scoreStack) {
            totalScore += score;
        }

        return totalScore;  
    }
}