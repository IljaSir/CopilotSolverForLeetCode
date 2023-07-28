impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..arr.len() {
            map.entry(arr[i]).or_insert(vec![]).push(i as i64);
        }
        let mut res = vec![0; arr.len()];
        for (k, v) in map {
            let mut sum = 0;
            let mut prev = 0;
            for i in 0..v.len() {
                let curr = v[i];
                sum += curr * (i as i64) - prev;
                prev += curr;
            }
            prev = 0;
            for i in (0..v.len()).rev() {
                let curr = v[i];
                sum += prev - curr * (i as i64 + 1);
                prev += curr;
            }
            for i in 0..v.len() {
                res[v[i] as usize] = sum;
            }
        }
        res
    }
}