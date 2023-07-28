impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut ans = 0;
        let mut cnt = 0;
        for i in 0..nums.len() - 1 {
            if nums[i] == key {
                let mut j = i + 1;
                while j < nums.len() && nums[j] == nums[i + 1] {
                    j += 1;
                }
                if j - i > cnt {
                    ans = nums[i + 1];
                    cnt = j - i;
                }
            }
        }
        ans
    }
}