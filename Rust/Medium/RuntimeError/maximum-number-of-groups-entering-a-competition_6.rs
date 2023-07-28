impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut groups = 0;
        let mut sum = 0;
        let mut count = 0;
        let mut i = 0;
        let mut j = grades.len() - 1;
        let mut grades = grades;
        grades.sort();
        while i <= j {
            let mut s = grades[j];
            let mut c = 1;
            j -= 1;
            while i <= j && s + grades[i] <= s + c {
                s += grades[i];
                c += 1;
                i += 1;
            }
            sum += s;
            count += c;
            if i < j && sum + grades[j] <= count + 1 {
                groups += 1;
                sum += grades[j];
                count += 1;
                j -= 1;
            }
        }
        groups + 1
    }
}