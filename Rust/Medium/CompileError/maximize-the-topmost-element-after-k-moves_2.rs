impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut i = 0;
        while i < n && nums[i] == 0 {
            i += 1;
        }
        if i as i32 > k {
            return nums[k as usize];
        }
        if i == n {
            return 0;
        }
        let k = k - i as i32;
        let mut j = i;
        while j < n && nums[j] == nums[i] {
            j += 1;
        }
        let mut count = j - i;
        let mut k = k;
        while k >= count {
            k -= count;
            i = j;
            while j < n && nums[j] == nums[i] {
                j += 1;
            }
            count = j - i;
        }
        if k == 0 {
            nums[i - 1]
        } else {
            nums[i - 1] + (k + count - 1) / count
        }
    }
}