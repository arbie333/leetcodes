/*
899. Orderly Queue (Hard)
https://leetcode.com/problems/orderly-queue/description/
 */

class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        StringBuilder ans = new StringBuilder(s);

        if (s.length() == 1) {
            return s;
        }

        if (k == 1) {
            String minstr = s;

            for (int i = 0; i < ans.length() - 1; i ++) {
                char cur = ans.charAt(0);
                for (int j = 0; j < ans.length() - 1; j++) {
                    ans.setCharAt(j, ans.charAt(j+1));
                }
                ans.setCharAt(s.length() - 1, cur);
                System.out.println("cur: " + cur);
                System.out.println("ans: " + ans.toString());

                if (ans.toString().compareTo(minstr) < 0) {
                    minstr = ans.toString();
                }
                System.out.println("min: " + minstr);
            }

            return minstr;
        }

        char[] charS = s.toCharArray();
        Arrays.sort(charS);

        return new String(charS);
    }
}