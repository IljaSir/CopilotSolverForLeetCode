impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        for num in nums {
            map.entry(num).and_modify(|x| *x += 1).or_insert(1);
        }
        for (key, value) in map {
            if value == 1 {
                return key;
            }
        }
        -1
    }
}