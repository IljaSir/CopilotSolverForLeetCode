impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut map = std::collections::HashMap::new();
        for num in nums2 {
            while let Some(&top) = stack.last() {
                if top < num {
                    let _ = stack.pop();
                    map.insert(top, num);
                } else {
                    break;
                }
            }
            stack.push(num);
        }
        nums1.into_iter().map(|n| map.get(&n).copied().unwrap_or(-1)).collect()
    }
}