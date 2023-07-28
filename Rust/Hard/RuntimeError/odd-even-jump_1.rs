impl Solution {
    pub fn odd_even_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut odd = vec![false; n];
        let mut even = vec![false; n];
        odd[n - 1] = true;
        even[n - 1] = true;
        let mut res = 1;
        let mut map = std::collections::BTreeMap::new();
        map.insert(arr[n - 1], n - 1);
        for i in (0..n - 1).rev() {
            let (&k1, _) = map.range(arr[i]..).next().unwrap();
            let (&k2, _) = map.range(..=arr[i]).next_back().unwrap();
            if let Some(&j) = map.get(&k1) {
                odd[i] = even[j];
            }
            if let Some(&j) = map.get(&k2) {
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