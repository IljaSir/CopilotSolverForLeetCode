class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
		long long sum = 0;
		sort(nums.begin(), nums.end());
		int i = 0;
		while (i < nums.size() && k > 0) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				++i;
				continue;
			}
			sum += nums[i];
			--k;
			++i;
		}
		while (k > 0) {
			sum += (i + 1);
			++i;
			--k;
		}
		return sum;
    }
};