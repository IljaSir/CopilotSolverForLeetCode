class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> result;
        vector<vector<int>> temp;
        for(auto i:restaurants){
            if(veganFriendly==0 || (veganFriendly==1 && i[2]==1)){
                if(i[3]<=maxPrice && i[4]<=maxDistance){
                    temp.push_back(i);
                }
            }
        }
        sort(temp.begin(),temp.end(),[](vector<int> a,vector<int> b){
            if(a[1]==b[1]){
                return a[0]>b[0];
            }
            return a[1]>b[1];
        });
        for(auto i:temp){
            result.push_back(i[0]);
        }
        return result;
    }
};