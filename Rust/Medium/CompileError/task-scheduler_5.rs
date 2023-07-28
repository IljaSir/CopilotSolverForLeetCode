impl Solution {
    pub fn least_interval(tasks: Vec<char>, n: i32) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        for c in tasks {
            let e = map.entry(c).or_insert(0);
            *e += 1;
        }
        let mut v = map.values().collect::<Vec<_>>();
        v.sort_by(|a, b| b.cmp(a));
        let max = v[0];
        let mut count = 0;
        for i in 0..v.len() {
            if v[i] == max {
                count += 1;
            }
        }
        let ans = (max - 1) * (n + 1) + count;
        std::cmp::max(ans, tasks.len()) as i32
    }
}