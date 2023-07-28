impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut count = vec![0; 1000001];
        let mut max = 0;
        for i in 0..nums.len() {
            count[nums[i] as usize] += 1;
            if count[nums[i] as usize] > max {
                max = count[nums[i] as usize];
            }
        }
        if max >= 3 {
            return true;
        }
        let mut i = 0;
        while i < nums.len() - 1 {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            if j - i >= 3 {
                return true;
            }
            if j < nums.len() - 1 && nums[j] == nums[i] + 1 && nums[j + 1] == nums[j] + 1 {
                return true;
            }
            i = j;
        }
        false
    }
}