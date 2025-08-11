class Solution {
public:
    bool isPalindrome(int x) {
    if(x<0) return false;
    int org = x, rev = 0;
    while(x>0){
        int dig = x%10;
        rev = rev*10+dig;
        x = x/10;
    }  
    return org = rev;
    }
};