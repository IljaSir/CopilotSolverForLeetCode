impl Solution {
    pub fn maximum_xor(nums: Vec<i32>) -> i32 {
        
        let mut mask = 0;
        let mut res = 0;
        for i in (0..32).rev() {
            mask |= 1 << i;
            let mut set = std::collections::HashSet::new();
            for num in nums.iter() {
                set.insert(num & mask);
            }
            let mut tmp = res | 1 << i;
            for prefix in set.iter() {
                if set.contains(&(prefix ^ tmp)) {
                    res = tmp;
                    break;
                }
            }
        }
        res
    }
}