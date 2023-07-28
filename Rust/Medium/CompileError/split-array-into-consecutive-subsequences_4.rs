impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for i in nums.iter() {
            *map.entry(*i).or_insert(0) += 1;
        }
        for i in nums.iter() {
            if let Some(&mut v) = map.get_mut(i) {
                if v > 0 {
                    for j in 1..=3 {
                        if let Some(&mut v1) = map.get_mut(&(i+j)) {
                            if v1 > 0 {
                                v -= 1;
                                v1 -= 1;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        true
    }
}