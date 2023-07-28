impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut v: Vec<char> = n.to_string().chars().collect();
        if !v.windows(2).any(|w| w[0] < w[1]) {
            return -1;
        }
        let mut i = v.len() - 2;
        while v[i] >= v[i + 1] {
            i -= 1;
        }
        let mut j = v.len() - 1;
        while v[j] <= v[i] {
            j -= 1;
        }
        v.swap(i, j);
        v[i + 1..].reverse();
        let res: i64 = v.into_iter().collect::<String>().parse().unwrap();
        if res > i32::max_value() as i64 {
            -1
        } else {
            res as i32
        }
    }
}