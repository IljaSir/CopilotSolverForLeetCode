impl Solution {
    pub fn array_change(nums: Vec<i32>, operations: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut m = HashMap::new();
        for op in operations {
            m.insert(op[0], op[1]);
        }
        for i in 0..nums.len() {
            if m.contains_key(&nums[i]) {
                nums[i] = *m.get(&nums[i]).unwrap();
            }
        }
        nums
    }
}