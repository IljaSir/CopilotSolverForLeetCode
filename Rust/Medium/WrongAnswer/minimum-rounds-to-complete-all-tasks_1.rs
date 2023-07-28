impl Solution {
    pub fn minimum_rounds(tasks: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for &t in tasks.iter() {
            *map.entry(t).or_insert(0) += 1;
        }
        let mut v = map.values().collect::<Vec<&i32>>();
        v.sort();
        let mut ans = 0;
        for &n in v.iter().rev() {
            let mut t = n / 3;
            if n % 3 != 0 {
                t += 1;
            }
            ans = ans.max(t);
        }
        ans * 2
    }
}