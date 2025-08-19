#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std ;

vector<int> sum(vector<int>& nums , int tar) {
    unordered_map<int , int > mp;
    for (int i = 0 ; i < nums.size() ; i++) {
        int comp = tar - nums[i] ;

        if (mp.find(comp) )
    }
}