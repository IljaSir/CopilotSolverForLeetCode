impl Solution {
    pub fn count_triples(n: i32) -> i32 {
        
        (1..=n).flat_map(|a| (a..=n).map(move |b| (a, b))).filter(|&(a, b)| {
            let c = a * a + b * b;
            let c = c as f64;
            let c = c.sqrt();
            let c = c as i32;
            c * c == a * a + b * b && c <= n
        }).count() as i32
    }
}