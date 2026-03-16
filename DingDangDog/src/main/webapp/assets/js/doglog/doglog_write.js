const imageUpload = document.getElementById("imageUpload");
const thumbnailPreview = document.getElementById("thumbnailPreview");
const writeContentEditor = document.getElementById("writeContentEditor");
const imgPlaceholder = document.querySelector(".img-placeholder");
const titleInput = document.querySelector(".write-title input");
const btnSave = document.querySelector(".btn-save");

let uploadedImages = [];

if (!imageUpload || !thumbnailPreview || !writeContentEditor || !imgPlaceholder || !titleInput || !btnSave) {
  throw new Error("필요한 요소를 찾을 수 없습니다.");
}

imageUpload.addEventListener("change", handleImageUpload);
writeContentEditor.addEventListener("click", handleEditorClick);
btnSave.addEventListener("click", handleSubmit);

function handleImageUpload(event) {
  const files = Array.from(event.target.files || []);
  const imageFiles = files.filter((file) => file.type.startsWith("image/"));

  if (!imageFiles.length) {
    alert("이미지 파일만 첨부할 수 있습니다.");
    imageUpload.value = "";
    return;
  }

  let loadedCount = 0;

  imageFiles.forEach((file) => {
    const reader = new FileReader();

    reader.onload = (e) => {
      uploadedImages.push({
        id: Date.now() + Math.random(),
        src: e.target.result
      });

      loadedCount += 1;

      if (loadedCount === imageFiles.length) {
        renderThumbnail();
        appendImagesToEditor(imageFiles.length);
      }
    };

    reader.readAsDataURL(file);
  });

  imageUpload.value = "";
}

function appendImagesToEditor(newImageCount) {
  const newImages = uploadedImages.slice(-newImageCount);

  newImages.forEach((image) => {
    const wrapper = createImageWrapper(image);
    writeContentEditor.appendChild(wrapper);
    writeContentEditor.appendChild(document.createElement("br"));
  });
}

function createImageWrapper(image) {
  const wrapper = document.createElement("div");
  wrapper.className = "editor-image-item";
  wrapper.dataset.imageId = image.id;
  wrapper.contentEditable = "false";

  const deleteButton = document.createElement("button");
  deleteButton.type = "button";
  deleteButton.className = "btn-editor-image-delete";
  deleteButton.dataset.action = "delete-image";
  deleteButton.textContent = "×";

  const img = document.createElement("img");
  img.src = image.src;
  img.alt = "첨부 이미지";

  wrapper.appendChild(deleteButton);
  wrapper.appendChild(img);

  return wrapper;
}

function handleEditorClick(event) {
  const deleteButton = event.target.closest('[data-action="delete-image"]');
  if (!deleteButton) return;

  const imageItem = deleteButton.closest(".editor-image-item");
  if (!imageItem) return;

  const imageId = Number(imageItem.dataset.imageId);
  removeImage(imageId, imageItem);
}

function removeImage(imageId, imageElement) {
  uploadedImages = uploadedImages.filter((image) => image.id !== imageId);

  const nextNode = imageElement.nextSibling;
  imageElement.remove();

  if (nextNode && nextNode.nodeName === "BR") {
    nextNode.remove();
  }

  renderThumbnail();
}

function renderThumbnail() {
  if (!uploadedImages.length) {
    thumbnailPreview.src = "";
    thumbnailPreview.style.display = "none";
    imgPlaceholder.style.display = "block";
    return;
  }

  thumbnailPreview.src = uploadedImages[0].src;
  thumbnailPreview.style.display = "block";
  imgPlaceholder.style.display = "none";
}

function handleSubmit(event) {
  event.preventDefault();

  const titleValue = titleInput.value.trim();

  if (!uploadedImages.length) {
    alert("이미지는 최소 1장 이상 첨부해야 합니다.");
    return;
  }

  if (!titleValue) {
    alert("제목을 입력해주세요.");
    titleInput.focus();
    return;
  }

  const submitData = {
    title: titleValue,
    thumbnail: uploadedImages[0]?.src || "",
    content: writeContentEditor.innerHTML,
    imageCount: uploadedImages.length
  };

  console.log("등록 데이터", submitData);
  alert("저장 가능 상태입니다.");
}