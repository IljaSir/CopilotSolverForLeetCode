impl Solution {
    pub fn minimum_removal(beans: Vec<i32>) -> i64 {
        
        let mut beans = beans;
        beans.sort();
        let mut total = beans.iter().sum::<i32>();
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        while i < beans.len() {
            let mut tmp = total;
            while j < beans.len() && beans[i] == beans[j] {
                tmp -= beans[j];
                j += 1;
            }
            if (beans.len() - j) * beans[i] == tmp {
                count += beans.len() - j;
                break;
            }
            i = j;
            total = tmp;
        }
        count as i64
    }
}