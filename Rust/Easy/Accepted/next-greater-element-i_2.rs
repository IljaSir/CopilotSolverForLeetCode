impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut map = std::collections::HashMap::new();
        for &n in nums2.iter() {
            while !stack.is_empty() && stack.last().unwrap() < &n {
                map.insert(stack.pop().unwrap(), n);
            }
            stack.push(n);
        }
        nums1.into_iter().map(|n| *map.get(&n).unwrap_or(&-1)).collect()
    }
}