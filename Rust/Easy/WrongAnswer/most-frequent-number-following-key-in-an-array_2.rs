impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut res = 0;
        let mut count = 0;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == key && i < nums.len() - 1 {
                let mut j = i + 1;
                while j < nums.len() && nums[j] != key {
                    j += 1;
                }
                if j < nums.len() {
                    let mut k = j + 1;
                    while k < nums.len() && nums[k] == nums[j] {
                        k += 1;
                    }
                    if k - j > count {
                        count = k - j;
                        res = nums[j];
                    }
                    i = k;
                } else {
                    break;
                }
            } else {
                i += 1;
            }
        }
        res
    }
}