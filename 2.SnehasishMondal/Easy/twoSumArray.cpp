#include<iostream>
using namespace std ;

int main () {
    int n ;
    cout << "Enter the size of the array : " ;
    cin >> n ;
    int arr[n];
    cout << "Enter the elements of the array :" ;
    for (int i = 0 ; i < n ; i++) {
        cin >> arr[i];
    }
    cout << "Enter the target sum : " ;
    int s ;
    cin >> s ;
    // Brute force approach
    for (int i = 0 ; i < n ; i++) {
        for (int j = i+1 ; j < n ; j++) {
            if (arr[i] + arr[j] == s) {
                cout << "The sum of those two element's index is : " ;
                cout << i << " and " << j << endl;
            }
        }
    }
    return 0 ;
}