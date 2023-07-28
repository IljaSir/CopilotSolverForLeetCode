impl Solution {
    pub fn find_maximum_xor(nums: Vec<i32>) -> i32 {
        

        let mut max = 0;
        let mut mask = 0;
        for i in (0..=30).rev() {
            mask |= 1 << i;
            let mut set = std::collections::HashSet::new();
            for num in nums.iter() {
                set.insert(num & mask);
            }
            let tmp = max | (1 << i);
            for prefix in set.iter() {
                if set.contains(&(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        max
    }
}