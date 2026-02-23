class Solution {
    public int bestClosingTime(String customers) {
        int totalY = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') totalY++;
        }

        int leftN = 0;
        int minPenalty = totalY;  // closing at hour 0
        int bestHour = 0;

        int remainingY = totalY;

        for (int j = 0; j < customers.length(); j++) {
            if (customers.charAt(j) == 'Y') {
                remainingY--;
            } else {
                leftN++;
            }

            int penalty = leftN + remainingY;

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j + 1;
            }
        }

        return bestHour;
    }
}