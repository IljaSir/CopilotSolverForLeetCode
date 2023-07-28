impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut ans = vec![];
        for q in queries {
            for d in &dictionary {
                if q == *d || Self::is_one_edit(q.chars().zip(d.chars())) || Self::is_two_edit(q.chars().zip(d.chars())) {
                    ans.push(q);
                    break;
                }
            }
        }
        ans
    }
    fn is_one_edit<'a, I>(mut iter: I) -> bool
    where
        I: Iterator<Item = (char, char)> + 'a,
    {
        let mut count = 0;
        while let Some((q, d)) = iter.next() {
            if q != d {
                count += 1;
                if count > 1 {
                    return false;
                }
            }
        }
        count == 1
    }
    fn is_two_edit<'a, I>(mut iter: I) -> bool
    where
        I: Iterator<Item = (char, char)> + 'a,
    {
        let mut count = 0;
        while let Some((q, d)) = iter.next() {
            if q != d {
                count += 1;
                if count > 2 {
                    return false;
                }
            }
        }
        count == 2
    }
}