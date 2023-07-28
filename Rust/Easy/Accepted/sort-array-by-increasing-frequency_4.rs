impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for &n in nums.iter() {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut v: Vec<_> = map.into_iter().collect();
        v.sort_by_key(|&(k, v)| (v, -k));
        v.into_iter().flat_map(|(k, v)| std::iter::repeat(k).take(v as usize)).collect()
    }
}