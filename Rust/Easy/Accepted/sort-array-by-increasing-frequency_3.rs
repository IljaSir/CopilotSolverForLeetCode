impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for i in nums {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut vec: Vec<_> = map.into_iter().collect();
        vec.sort_by(|a, b| {
            if a.1 == b.1 {
                b.0.cmp(&a.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        let mut ans = Vec::new();
        for i in vec {
            for _ in 0..i.1 {
                ans.push(i.0);
            }
        }
        ans
    }
}