impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for n in nums {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut vec: Vec<(i32, i32)> = map.into_iter().collect();
        vec.sort_by(|x, y| {
            if x.1 == y.1 {
                y.0.cmp(&x.0)
            } else {
                x.1.cmp(&y.1)
            }
        });
        vec.iter().flat_map(|(k, v)| std::iter::repeat(*k).take(*v as usize)).collect()
    }
}