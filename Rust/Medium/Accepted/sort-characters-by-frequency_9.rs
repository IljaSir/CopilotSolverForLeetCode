impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        let mut v = s.chars().collect::<Vec<char>>();
        v.sort_by(|a, b| b.cmp(a));
        let mut v1 = Vec::new();
        let mut i = 0;
        while i < v.len() {
            let mut j = i + 1;
            while j < v.len() && v[j] == v[i] {
                j += 1;
            }
            v1.push((v[i], j - i));
            i = j;
        }
        v1.sort_by(|a, b| b.1.cmp(&a.1));
        let mut v2 = Vec::new();
        for (c, n) in v1 {
            for _ in 0..n {
                v2.push(c);
            }
        }
        v2.iter().collect::<String>()
    }
}