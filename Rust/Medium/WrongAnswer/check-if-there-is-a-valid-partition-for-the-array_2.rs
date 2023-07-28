impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut v = Vec::new();
        let mut c = 1;
        for i in 1..nums.len() {
            if nums[i] == nums[i - 1] {
                c += 1;
            } else {
                v.push(c);
                c = 1;
            }
        }
        v.push(c);
        let mut c2 = 0;
        for i in 0..v.len() {
            if v[i] >= 2 {
                c2 += 1;
            }
        }
        if c2 >= 2 {
            return true;
        }
        for i in 1..v.len() {
            if v[i - 1] == 1 && v[i] >= 3 {
                return true;
            }
        }
        false
    }
}