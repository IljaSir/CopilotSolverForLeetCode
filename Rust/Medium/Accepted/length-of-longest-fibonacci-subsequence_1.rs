impl Solution {
    pub fn len_longest_fib_subseq(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut f = vec![vec![2; n]; n];
        let mut ans = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..n {
            map.insert(arr[i], i);
        }
        for i in 1..n {
            for j in 0..i {
                let target = arr[i] - arr[j];
                if target < arr[j] && map.contains_key(&target) {
                    let k = map[&target];
                    f[j][i] = f[k][j] + 1;
                }
                ans = ans.max(f[j][i]);
            }
        }
        if ans > 2 { ans } else { 0 }
    }
}