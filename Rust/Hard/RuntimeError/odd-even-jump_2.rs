impl Solution {
    pub fn odd_even_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut dp_odd = vec![false; n];
        let mut dp_even = vec![false; n];
        dp_odd[n-1] = true;
        dp_even[n-1] = true;
        let mut ans = 1;
        let mut tree = std::collections::BTreeMap::new();
        tree.insert(arr[n-1], n-1);
        for i in (0..n-1).rev() {
            let (&next_odd, _) = tree.range(arr[i]..).next().unwrap_or((&0, &0));
            let (&next_even, _) = tree.range(..=arr[i]).next_back().unwrap_or((&0, &0));
            dp_odd[i] = dp_even[next_odd as usize];
            dp_even[i] = dp_odd[next_even as usize];
            if dp_odd[i] {
                ans += 1;
            }
            tree.insert(arr[i], i);
        }
        ans
    }
}