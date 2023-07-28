impl Solution {
    pub fn odd_even_jumps(arr: Vec<i32>) -> i32 {
        
        let mut odd = vec![false; arr.len()];
        let mut even = vec![false; arr.len()];
        let mut map = std::collections::BTreeMap::new();
        odd[arr.len() - 1] = true;
        even[arr.len() - 1] = true;
        map.insert(arr[arr.len() - 1], arr.len() - 1);
        let mut res = 1;
        for i in (0..arr.len() - 1).rev() {
            if let Some(&j) = map.range(arr[i]..).next() {
                odd[i] = even[j];
            }
            if let Some(&j) = map.range(..=arr[i]).rev().next() {
                even[i] = odd[j];
            }
            if odd[i] {
                res += 1;
            }
            map.insert(arr[i], i);
        }
        res
    }
}