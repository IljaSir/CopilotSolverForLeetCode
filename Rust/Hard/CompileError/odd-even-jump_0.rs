impl Solution {
    pub fn odd_even_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut odd = vec![false; n];
        let mut even = vec![false; n];
        odd[n - 1] = true;
        even[n - 1] = true;
        let mut map = std::collections::BTreeMap::new();
        map.insert(arr[n - 1], n - 1);
        let mut res = 1;
        for i in (0..n - 1).rev() {
            if let Some(&x) = map.range(arr[i]..).next() {
                odd[i] = even[x];
            }
            if let Some(&x) = map.range(..=arr[i]).rev().next() {
                even[i] = odd[x];
            }
            if odd[i] {
                res += 1;
            }
            map.insert(arr[i], i);
        }
        res
    }
}