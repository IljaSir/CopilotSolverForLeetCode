impl Solution {
    pub fn find_shortest_sub_array(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            map.entry(nums[i]).or_insert(vec![i, 0, 0])[1] += 1;
            map.entry(nums[i]).or_insert(vec![i, 0, 0])[2] = i;
        }
        let max = map.values().max_by_key(|x| x[1]).unwrap()[1];
        let mut ret = nums.len() as i32;
        for v in map.values() {
            if v[1] == max {
                ret = ret.min(v[2] - v[0] + 1);
            }
        }
        ret
    }
}