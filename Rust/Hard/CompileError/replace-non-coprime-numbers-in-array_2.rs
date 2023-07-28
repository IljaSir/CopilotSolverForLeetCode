impl Solution {
    pub fn replace_non_coprimes(nums: Vec<i32>) -> Vec<i32> {
        
        let mut v = vec![0; 100001];
        let mut res = vec![0; nums.len()];
        for i in 2..100001 {
            if v[i] == 0 {
                let mut j = i;
                while j < 100001 {
                    v[j] = i;
                    j += i;
                }
            }
        }
        for i in 0..nums.len() {
            let mut j = i + 1;
            while j < nums.len() && v[nums[i] as usize] == v[nums[j] as usize] {
                j += 1;
            }
            if j < nums.len() && v[nums[i] as usize] != v[nums[j] as usize] {
                res[i] = nums[j];
                res[j] = nums[i];
                i = j;
            } else {
                res[i] = nums[i];
            }
        }
        res
    }
}