//! Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

//! Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

//! Example 1:

//! Input: x = 123
// !Output: 321
// !Example 2:

// !Input: x = -123
// !Output: -321
//! Example 3:

// !Input: x = 120
//! Output: 21
 

//! Constraints:

//! -231 <= x <= 231 - 1







// LeetCode-ready solution (class name Solution, method reverse)
class reverseinteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check overflow/underflow before multiplying by 10
            if (res > 214748364 || (res == 214748364 && digit > 7)) return 0;
            if (res < -214748364 || (res == -214748364 && digit < -8)) return 0;

            res = res * 10 + digit;
        }
        return res;
    }

    // Local test harness
    public static void main(String[] args) {
        reverseinteger solver = new reverseinteger();
        if (args.length > 0) {
            for (String a : args) {
                try {
                    int v = Integer.parseInt(a);
                    System.out.println(v + " -> " + solver.reverse(v));
                } catch (NumberFormatException e) {
                    System.out.println(a + " -> invalid int");
                }
            }
            return;
        }
        int[] samples = {123, -123, 120, 0, 1534236469};
        for (int v : samples) {
            System.out.println(v + " -> " + solver.reverse(v));
        }
    }
}