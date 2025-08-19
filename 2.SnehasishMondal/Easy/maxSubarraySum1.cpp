#include<iostream>
#include<climits>
using namespace std ;

int main () {
    cout << "Enter the size of the array : " ;
    int n ;
    cin >> n ;

    int arr[n] ;
    cout << "Enter the elements of the Array : " ;
    for (int i = 0 ; i < n ; i++) {
        cin >> arr[i] ;
    }

    int maxSum = INT_MIN;
    for (int st = 0 ; st < n ; st++) {
        for (int end = st ; end < n ; end++) {
            int curSum = 0 ;
            for (int i = st ; i < end ; i++) {
                curSum = curSum + arr[i] ;
            }
            maxSum = max(maxSum , curSum);
        }
    }
    cout << "The result of the maximum Subarray element is : " << maxSum;
    return 0 ;

}