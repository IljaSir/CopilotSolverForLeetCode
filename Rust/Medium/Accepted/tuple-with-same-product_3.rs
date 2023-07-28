impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let p = nums[i] * nums[j];
                if let Some(v) = map.get_mut(&p) {
                    *v += 1;
                } else {
                    map.insert(p, 1);
                }
            }
        }
        for v in map.values() {
            count += v * (v-1) / 2 * 8;
        }
        count
    }
}