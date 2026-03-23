function circleClick(circle, circles, radios, index, qIndex, allItems) {
  circles.forEach((c) => c.classList.remove("active"));
  circle.classList.add("active");

  if (radios[index]) {
    radios[index].checked = true;
  }

  const nextItem = allItems[qIndex + 1];
  if (nextItem) {
    setTimeout(() => {
      nextItem.scrollIntoView({ behavior: "smooth", block: "center" });
    }, 200);
  }
}

const surveyForm = document.querySelector("#dogmatching-form");
const surveyItems = document.querySelectorAll(".survey-items");

surveyItems.forEach((item, qIndex) => {
  const questionNumber = qIndex + 1;
  const circles = item.querySelectorAll(".circle");
  const radios = item.querySelectorAll(".survey-radio");

  radios.forEach((radio) => {
    radio.name = `survey-q${questionNumber}`;
  });

  circles.forEach((circle, cIndex) => {
    circle.addEventListener("click", () => {
      circleClick(circle, circles, radios, cIndex, qIndex, surveyItems);
    });
  });
});

function getCheckedValue(questionNumber) {
  const checkedRadio = document.querySelector(
    `input[name="survey-q${questionNumber}"]:checked`
  );
  return checkedRadio ? Number(checkedRadio.value) : 0;
}

surveyForm.addEventListener("submit", (e) => {
  let firstUnansweredItem = null;

  for (let i = 0; i < surveyItems.length; i++) {
    const radios = surveyItems[i].querySelectorAll(".survey-radio");
    const isChecked = Array.from(radios).some((radio) => radio.checked);

    if (!isChecked) {
      firstUnansweredItem = surveyItems[i];
      break;
    }
  }

  if (firstUnansweredItem) {
    e.preventDefault();
    alert("아직 답변하지 않은 문항이 있습니다.");
    firstUnansweredItem.scrollIntoView({
      behavior: "smooth",
      block: "center",
    });
    return;
  }

  const dogActivity =
    getCheckedValue(1) +
    getCheckedValue(2) +
    getCheckedValue(3) +
    getCheckedValue(4);

  const dogSociality =
    getCheckedValue(5) +
    getCheckedValue(6) +
    getCheckedValue(7) +
    getCheckedValue(8);

  const dogIndependence =
    getCheckedValue(9) +
    getCheckedValue(10) +
    getCheckedValue(11) +
    getCheckedValue(12);

  const dogBarking =
    getCheckedValue(13) +
    getCheckedValue(14) +
    getCheckedValue(15) +
    getCheckedValue(16);

  const dogGrooming =
    getCheckedValue(17) +
    getCheckedValue(18) +
    getCheckedValue(19) +
    getCheckedValue(20);

  document.querySelector("#dogActivity").value = dogActivity;
  document.querySelector("#dogSociality").value = dogSociality;
  document.querySelector("#dogIndependence").value = dogIndependence;
  document.querySelector("#dogBarking").value = dogBarking;
  document.querySelector("#dogGrooming").value = dogGrooming;
});